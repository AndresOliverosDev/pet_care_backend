INSERT INTO races (`name`) VALUES
('Labrador Retriever'),
('Pastor Alemán'),
('Bulldog'),
('Golden Retriever'),
('Poodle'),
('Beagle'),
('Dachshund'),
('Chihuahua'),
('Boxer'),
('Schnauzer');

INSERT INTO roles (`name`) VALUES
    ('ADMIN'),
    ('USER'),
    ('INVITED'),
    ('DEVELOPER');

INSERT INTO `permissions` (`name`) VALUES
('READ'),
('WRITE'),
('DELETE'),
('UPDATE'),
('CREATE');

INSERT INTO users (id, username, `password`, is_enable, account_no_expired, account_no_locked, credential_no_expired, `names`, surnames, `address`, phone) VALUES
(1, 'john_doe', 'password123', true, true, false, true, 'John', 'Doe', '123 Main St', '1234567890'),
(2, 'jane_smith', 'password456', true, true, false, true, 'Jane', 'Smith', '456 Elm St', '2345678901'),
(3, 'bob_jones', 'password789', true, true, false, true, 'Bob', 'Jones', '789 Oak St', '3456789012'),
(4, 'mary_davis', 'passwordabc', true, true, false, true, 'Mary', 'Davis', '101 Pine St', '4567890123'),
(5, 'sam_wilson', 'passworddef', true, true, false, true, 'Sam', 'Wilson', '202 Maple St', '5678901234'),
(6, 'sarah_brown', 'passwordghi', true, true, false, true, 'Sarah', 'Brown', '303 Cedar St', '6789012345'),
(7, 'chris_thomas', 'passwordjkl', true, true, false, true, 'Chris', 'Thomas', '404 Birch St', '7890123456'),
(8, 'emily_taylor', 'passwordmno', true, true, false, true, 'Emily', 'Taylor', '505 Walnut St', '8901234567'),
(9, 'alex_martin', 'passwordpqr', true, true, false, true, 'Alex', 'Martin', '606 Pine St', '9012345678'),
(10, 'jessica_lee', 'passwordstu', true, true, false, true, 'Jessica', 'Lee', '707 Cedar St', '0123456789');

INSERT INTO users_roles (user_id, rol_id) VALUES
('1', 1),
('2', 2),
('3', 3),
('4', 4),
('5', 1),
('6', 2),
('7', 3),
('8', 4),
('9', 1),
('10', 2);

INSERT INTO roles_permissions (rol_id, permission_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4);

INSERT INTO pets (`name`, age, color, gender, specie, owner_id, race_id) VALUES
('Max', 3, 'Brown', 'Male', 'Dog', '1', 1),
('Bella', 2, 'White', 'Female', 'Cat', '2', 2),
('Charlie', 5, 'Black', 'Male', 'Dog', '3', 3),
('Luna', 1, 'Gray', 'Female', 'Cat', '4', 4),
('Buddy', 4, 'Golden', 'Male', 'Dog', '5', 5),
('Daisy', 2, 'Orange', 'Female', 'Dog', '6', 6),
('Rocky', 6, 'Gray', 'Male', 'Cat', '7', 7),
('Lucy', 3, 'Brown', 'Female', 'Dog', '8', 8),
('Bailey', 1, 'Black', 'Male', 'Dog', '9', 9),
('Molly', 4, 'White', 'Female', 'Cat', '10', 10);

SELECT
	u.id, u.username, r.name AS rol, p.name AS permission_name
FROM
	users u
		INNER JOIN
        users_roles ur ON u.id = ur.user_id
        INNER JOIN
        roles r ON ur.rol_id = r.id
        INNER JOIN
        roles_permissions rp ON r.id = rp.rol_id
		INNER JOIN
        permissions p ON rp.permission_id = p.id;