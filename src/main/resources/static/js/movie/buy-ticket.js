document.addEventListener("DOMContentLoaded", () => {
    const seatMapContainer = document.getElementById("seatmap");
    const orderSummary = document.getElementById("order-summary");
    const summaryMovie = document.getElementById("summary-movie");
    const summarySeats = document.getElementById("summary-seats");
    const total = document.getElementById("total");
    const loadSeatsButton = document.getElementById("load-seats");

    let selectedSeats = [];
    const ticketPrice = 20;

    // Function to render seat map
    function renderSeatMap(seats) {
        seatMapContainer.innerHTML = "";
        seats.forEach((row, rowIndex) => {
            row.forEach((seat, seatIndex) => {
                const seatElement = document.createElement("div");
                seatElement.classList.add("seat");
                seatElement.classList.add(seat.reserved ? "reserved" : "empty");
                seatElement.dataset.seatNumber = `${String.fromCharCode(65 + rowIndex)}${seatIndex + 1}`;

                // Hover behavior
                seatElement.addEventListener("mouseenter", () => {
                    if (seat.reserved) {
                        seatElement.title = "Already Reserved";
                    } else {
                        seatElement.title = seatElement.dataset.seatNumber;
                    }
                });

                // Click behavior for empty seats
                if (!seat.reserved) {
                    seatElement.addEventListener("click", () => {
                        if (seatElement.classList.contains("selected")) {
                            seatElement.classList.remove("selected");
                            selectedSeats = selectedSeats.filter(
                                (s) => s !== seatElement.dataset.seatNumber
                            );
                        } else {
                            seatElement.classList.add("selected");
                            selectedSeats.push(seatElement.dataset.seatNumber);
                        }
                        updateOrderSummary();
                    });
                }

                seatMapContainer.appendChild(seatElement);
            });
        });
    }

    // Function to update the order summary
    function updateOrderSummary() {
        const movieName = document.querySelector("h1").textContent;
        const selectedDate = document.getElementById("date-time").value;

        // Update movie and time
        summaryMovie.textContent = `${movieName} at ${selectedDate}`;

        // Update seat list
        summarySeats.innerHTML = "";
        selectedSeats.forEach((seat) => {
            const seatItem = document.createElement("li");
            seatItem.innerHTML = `Seat ${seat} <span>$${ticketPrice}</span>`;
            summarySeats.appendChild(seatItem);
        });

        // Update total
        total.textContent = `Total: $${selectedSeats.length * ticketPrice}`;
    }

    // Simulated seat data and load behavior
    loadSeatsButton.addEventListener("click", () => {
        // Simulated reserved seat data (replace with actual server request)
        const seats = Array(8)
            .fill(null)
            .map(() =>
                Array(10)
                    .fill(null)
                    .map(() => ({ reserved: Math.random() < 0.3 })) // 30% reserved
            );

        renderSeatMap(seats);
        selectedSeats = [];
        updateOrderSummary();
    });
});
