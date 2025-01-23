-- Insert users into the user_auth table (authentication-related data)
-- Clear Text Password: "password123"
INSERT INTO user_auth (username, password_hash, role) VALUES
('john.doe', '$2a$10$Y8byPEQA0SjJkh0gMyF13Or4vZAgdt4bEh/Ha4SJOZzbMukaKHTny', 'student'),
('jane.smith', '$2a$10$XWA0v0fXlhHjPEEzYh5t.e5x5gTTftCkp5WlYqYVMW5AzVRrPbYgu', 'teacher'),
('mark.johnson', '$2a$10$KKeLLdv2pi/Qt.53z0tkxOYwNNj5CIPqkOd9fr01XrTJIEQJFZV/m', 'parent'),
('emily.jones', '$2a$10$dI5Tt26fL.Wwe2ts2rZJq.0RMbRkneKaBI8BI5ClGBZeyaqA.WJTC', 'student'),
('olivia.williams', '$2a$10$qvqvb1n9qj/97fzvKPOdguLbkhVl.k2HziT9flW8vKyHX1dnO0ZXm', 'student'),
('william.brown', '$2a$10$V.pPn8HjtaoRVlPyEOBo9OQdw479WCNSsgzrvmLCjPDaTPop1YB2O', 'parent'),
('ava.davis', '$2a$10$ez/WDvKqAoh16rwOwCS4ruUGVtDNngI8UhD5PpniaHy6brX9VtPWa', 'student'),
('michael.moore', '$2a$10$bAZvCoQRHfV8Sl3XJnM0SOvycBca3pBMZNVuR56sWoKW.uPe89Ko2', 'teacher'),
('lucas.martin', '$2a$10$Dnkg5tmzUye6CXVNBo7Kw.JTByOq20Ksue/0ab9scQ0FyW8pxKtQm', 'parent'),
('sophia.miller', '$2a$10$TuE0irXoMb8IsYIPYjwcU.RYXWG3bhYFGLh4287GRfnvaOfwHxLDu', 'parent');

-- Insert user profile data (application-specific data)
INSERT INTO user_profile (user_id, first_name, last_name, email) VALUES 
(1, 'John', 'Doe', 'john.doe@student.com'),
(2, 'Jane', 'Smith', 'jane.smith@school.com'),
(3, 'Mark', 'Johnson', 'mark.johnson@parent.com'),
(4, 'Emily', 'Jones', 'emily.jones@student.com'),
(5, 'Olivia', 'Williams', 'olivia.williams@student.com'),
(6, 'William', 'Brown', 'william.brown@parent.com'),
(7, 'Ava', 'Davis', 'ava.davis@student.com'),
(8, 'Michael', 'Moore', 'michael.moore@school.com'),
(9, 'Lucas', 'Martin', 'lucas.martin@parent.com'),
(10, 'Sophia', 'Miller', 'sophia.miller@parent.com');

-- Insert classes (teachers with classes)
INSERT INTO classes (name, teacher_id) VALUES 
('Math 101', 2), -- Jane Smith is teaching Math 101
('Science 101', 8); -- Michael Moore is teaching Science 101

-- Insert enrollments (students to classes)
INSERT INTO enrollment (student_id, class_id) VALUES
(1, 1), -- John Doe in Class 1
(4, 1), -- Emily Jones in Class 1
(5, 1), -- Olivia Williams in Class 1
(7, 2); -- Ava Davis in Class 2

-- Insert parent-child relationships
INSERT INTO parent_child (parent_id, child_id) VALUES
(3, 1), -- Mark Johnson is a parent of John Doe
(6, 4), -- William Brown is a parent of Emily Jones
(6, 5), -- William Brown is a parent of Olivia Williams
(9, 7), -- Lucas Martin is a parent of Ava Davis
(10, 7); -- Sophia Miller is a parent of Ava Davis

