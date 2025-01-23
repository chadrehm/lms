-- User authentication table to store credentials and roles
CREATE TABLE user_auth (
    id SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    role VARCHAR(20) CHECK (role IN ('student', 'parent', 'teacher')) NOT NULL,
    last_login TIMESTAMP,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- User profile table to store personal and application-specific information
CREATE TABLE user_profile (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL REFERENCES user_auth(id),
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (user_id)
);

-- Class table to store course information
CREATE TABLE classes (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    teacher_id INT NOT NULL REFERENCES user_profile(id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Enrollment table to track which students are in which classes
CREATE TABLE enrollment (
    id SERIAL PRIMARY KEY,
    student_id INT NOT NULL REFERENCES user_profile(id),
    class_id INT NOT NULL REFERENCES classes(id),
    UNIQUE (student_id, class_id)
);

-- Grade table to track student grades in classes
CREATE TABLE grades (
    id SERIAL PRIMARY KEY,
    enrollment_id INT NOT NULL REFERENCES enrollment(id),
    grade VARCHAR(2), -- E.g., A+, B, etc.
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Parent-child relationship table
CREATE TABLE parent_child (
    id SERIAL PRIMARY KEY,
    parent_id INT NOT NULL REFERENCES user_profile(id),
    child_id INT NOT NULL REFERENCES user_profile(id),
    UNIQUE (parent_id, child_id)
);
