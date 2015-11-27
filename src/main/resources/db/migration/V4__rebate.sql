INSERT INTO rebate (description, type, end_period, discount_percentage, quantity_threshold, start_period, time_of_year)
VALUES ('regular fixed value discount 10', 1, DATE_ADD(NOW(), INTERVAL 10 DAY), 10, null, NOW(), null);

INSERT INTO rebate (description, type, end_period, discount_percentage, quantity_threshold, start_period, time_of_year)
VALUES ('regular fixed value discount 5', 1, DATE_ADD(NOW(), INTERVAL 10 DAY), 5, null, NOW(), null);

INSERT INTO rebate (description, type, end_period, discount_percentage, quantity_threshold, start_period, time_of_year)
VALUES ('regular fixed value discount 15', 1, DATE_ADD(NOW(), INTERVAL 10 DAY), 15, null, NOW(), null);

INSERT INTO rebate (description, type, end_period, discount_percentage, quantity_threshold, start_period, time_of_year)
VALUES ('winter season holidays', 0, DATE_ADD(NOW(), INTERVAL 10 DAY), 10, null, NOW(), 0);

INSERT INTO rebate (description, type, end_period, discount_percentage, quantity_threshold, start_period, time_of_year)
VALUES ('bulk purchase', 2, DATE_ADD(NOW(), INTERVAL 10 DAY), 20, 2000, NOW(), null);

