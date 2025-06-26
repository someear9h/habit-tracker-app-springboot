import React, { useState, useEffect } from 'react';

export default function HabitForm({ onSubmit, initialData }) {
    const [habit, setHabit] = useState({
        name: '',
        description: '',
        email: '',
        habitDate: ''
    });

    useEffect(() => {
        if (initialData) setHabit(initialData);
    }, [initialData]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setHabit({ ...habit, [name]: value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        onSubmit(habit);
        setHabit({ name: '', description: '', email: '', habitDate: '' });
    };

    return (
        <form onSubmit={handleSubmit}>
            <input name="name" placeholder="Name" value={habit.name} onChange={handleChange} required />
            <input name="email" placeholder="Email" value={habit.email} onChange={handleChange} required />
            <input name="habitDate" type="date" value={habit.habitDate} onChange={handleChange} required />
            <textarea name="description" placeholder="Description" value={habit.description} onChange={handleChange} />
            <button type="submit">{initialData ? 'Update' : 'Create'}</button>
        </form>
    );
}
