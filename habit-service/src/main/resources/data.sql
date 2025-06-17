-- noinspection SqlNoDataSourceInspectionForFile

-- Ensure the 'habit' table exists
CREATE TABLE IF NOT EXISTS habit
(
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    email VARCHAR(255) NOT NULL,
    habit_date DATE NOT NULL
    );

-- Insert well-known UUIDs for specific habits
INSERT INTO habit (id, name, description, email, habit_date)
SELECT '11111111-1111-1111-1111-111111111111',
       'Morning Jog',
       'Jog for 30 minutes',
       'user1@example.com',
       '2025-06-01'
    WHERE NOT EXISTS (SELECT 1 FROM habit WHERE id = '11111111-1111-1111-1111-111111111111');

INSERT INTO habit (id, name, description, email, habit_date)
SELECT '22222222-2222-2222-2222-222222222222',
       'Read Book',
       'Read 20 pages',
       'user1@example.com',
       '2025-06-02'
    WHERE NOT EXISTS (SELECT 1 FROM habit WHERE id = '22222222-2222-2222-2222-222222222222');

INSERT INTO habit (id, name, description, email, habit_date)
SELECT '33333333-3333-3333-3333-333333333333',
       'Meditation',
       'Meditate for 10 minutes',
       'user2@example.com',
       '2025-06-03'
    WHERE NOT EXISTS (SELECT 1 FROM habit WHERE id = '33333333-3333-3333-3333-333333333333');

INSERT INTO habit (id, name, description, email, habit_date)
SELECT '44444444-4444-4444-4444-444444444444',
       'Drink Water',
       '8 glasses of water',
       'user3@example.com',
       '2025-06-04'
    WHERE NOT EXISTS (SELECT 1 FROM habit WHERE id = '44444444-4444-4444-4444-444444444444');

INSERT INTO habit (id, name, description, email, habit_date)
SELECT '55555555-5555-5555-5555-555555555555',
       'Sleep Early',
       'Sleep before 11 PM',
       'user3@example.com',
       '2025-06-05'
    WHERE NOT EXISTS (SELECT 1 FROM habit WHERE id = '55555555-5555-5555-5555-555555555555');

INSERT INTO habit (id, name, description, email, habit_date)
SELECT '66666666-6666-6666-6666-666666666666',
       'Write Journal',
       'Write daily journal',
       'user4@example.com',
       '2025-06-06'
    WHERE NOT EXISTS (SELECT 1 FROM habit WHERE id = '66666666-6666-6666-6666-666666666666');

INSERT INTO habit (id, name, description, email, habit_date)
SELECT '77777777-7777-7777-7777-777777777777',
       'Workout',
       'Full body workout',
       'user5@example.com',
       '2025-06-07'
    WHERE NOT EXISTS (SELECT 1 FROM habit WHERE id = '77777777-7777-7777-7777-777777777777');

INSERT INTO habit (id, name, description, email, habit_date)
SELECT '88888888-8888-8888-8888-888888888888',
       'Code Practice',
       '1 hour LeetCode',
       'user6@example.com',
       '2025-06-08'
    WHERE NOT EXISTS (SELECT 1 FROM habit WHERE id = '88888888-8888-8888-8888-888888888888');

INSERT INTO habit (id, name, description, email, habit_date)
SELECT '99999999-9999-9999-9999-999999999999',
       'Healthy Breakfast',
       'Eat fruits',
       'user7@example.com',
       '2025-06-09'
    WHERE NOT EXISTS (SELECT 1 FROM habit WHERE id = '99999999-9999-9999-9999-999999999999');

INSERT INTO habit (id, name, description, email, habit_date)
SELECT 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
       'Learning Spanish',
       'Duolingo lessons',
       'user8@example.com',
       '2025-06-10'
    WHERE NOT EXISTS (SELECT 1 FROM habit WHERE id = 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa');
