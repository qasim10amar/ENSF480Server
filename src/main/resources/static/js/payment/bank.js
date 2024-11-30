document.addEventListener("DOMContentLoaded", () => {
    const output = document.getElementById("output");

    // Button event listeners
    document.querySelector(".success").addEventListener("click", () => {
        output.textContent = "Payment successful!";
        output.style.color = "green";
    });

    document.querySelector(".reject").addEventListener("click", () => {
        output.textContent = "Payment rejected.";
        output.style.color = "red";
    });

    document.querySelector(".error").addEventListener("click", () => {
        output.textContent = "An error occurred during payment.";
        output.style.color = "orange";
    });
});
