-- Address Table
-- Theater Table
INSERT INTO Theater (theaterNumber, capacity, theaterType) VALUES
('Theater 1', 100, 'IMAX'),
('Theater 2', 100, 'Standard'),
('Theater 3', 100, '4D'),
('Theater 4', 100, 'VIP'),
('Theater 5', 100, 'Standard');
#
# Movie Table
# INSERT INTO Movie (title, genre, releaseDate) VALUES
# ('The Matrix', 'Sci-Fi', '1999-03-31'),
# ('Inception', 'Thriller', '2010-07-16'),
# ('Avengers: Endgame', 'Action', '2019-04-26'),
# ('Interstellar', 'Sci-Fi', '2014-11-07'),
# ('Titanic', 'Romance', '1997-12-19');
#
# -- ShowTime Table
# INSERT INTO ShowTime (movieId, theaterId, showTime) VALUES
# (1, 1, '2024-12-01 14:30:00'),
# (2, 2, '2024-12-01 19:00:00'),
# (3, 3, '2024-12-02 13:00:00'),
# (4, 4, '2024-12-02 16:00:00'),
# (5, 5, '2024-12-03 18:30:00');

-- Seat Table
# INSERT INTO Seat (seatRow, seatColumn, isReserved, showTimeId, seatPrice) VALUES
# (1, 1, FALSE, 1, 15),
# (1, 2, TRUE, 1, 15),
# (2, 1, FALSE, 2, 15),
# (2, 2, TRUE, 2, 15),
# (3, 1, FALSE, 3, 15),
# (3, 2, TRUE, 3, 15),
# (4, 1, FALSE, 4, 15),
# (4, 2, TRUE, 4, 15),
# (5, 1, FALSE, 5, 15),
# (5, 2, TRUE, 5, 15);


# -- Ticket Table
# INSERT INTO Ticket (userId, seatId, isPurchased, ticketPrice) VALUES
# (1, 2, TRUE, 15),
# (2, 4, TRUE, 15),
# (3, 6, TRUE, 15),
# (4, 8, TRUE, 15),
# (5, 10, TRUE, 15);
#
# -- Payment Table
# INSERT INTO Payment (ticketId, isPaid, cardNum) VALUES
# (1, TRUE, '1234567812355678'),
# (2, TRUE, '8765432187654321'),
# (3, TRUE, '5555555555555555'),
# (4, TRUE, '4444111122223333');
