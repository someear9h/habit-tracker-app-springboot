import React from 'react';

export default function HabitList({ habits, onEdit, onDelete }) {
    return (
        <div>
            <h2>Habits</h2>
            <ul>
                {habits.map(habit => (
                    <li key={habit.id}>
                        <b>{habit.name}</b> - {habit.email} - {habit.habitDate}
                        <br />
                        <i>{habit.description}</i>
                        <br />
                        <button onClick={() => onEdit(habit)}>Edit</button>
                        <button onClick={() => onDelete(habit.id)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}
