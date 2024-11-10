INSERT INTO brand (name, warranty, country)
VALUES ('Toyota', 3, 'Japan'),
       ('BMW', 2, 'Germany'),
       ('Ford', 3, 'USA'),
       ('Volkswagen', 4, 'Germany');

-- Insert sample cars
INSERT INTO car (brand_id, model, milleage, price, year, description, colour, fuel_type, num_doors)
VALUES (1, 'Corolla', 0, 25000.00, 2024, 'New Toyota Corolla Sedan', 'Silver', 'Gasoline', 4),
       (1, 'RAV4', 15000, 28000.00, 2023, 'Used Toyota RAV4 SUV', 'Blue', 'Hybrid', 5),
       (2, '330i', 0, 45000.00, 2024, 'New BMW 3 Series Sedan', 'Black', 'Gasoline', 4),
       (3, 'Mustang', 5000, 38000.00, 2023, 'Used Ford Mustang Sports Car', 'Red', 'Gasoline', 2),
       (4, 'Golf', 0, 30000.00, 2024, 'New Volkswagen Golf Hatchback', 'White', 'Electric', 5);