import React, { useEffect, useState } from 'react';
import { getHabits, createHabit, updateHabit, deleteHabit } from '../api/habitApi';
import HabitForm from '../components/HabitForm';
import HabitList from '../components/HabitList';

export default function Home() {
    const [habits, setHabits] = useState([]);
    const [editingHabit, setEditingHabit] = useState(null);

    useEffect(() => {
        loadHabits();
    }, []);

    const loadHabits = async () => {
        const res = await getHabits();
        setHabits(res.data);
    };

    const handleCreateOrUpdate = async (habit) => {
        try {
            if (editingHabit) {
                await updateHabit(editingHabit.id, habit);
                setEditingHabit(null);
            } else {
                await createHabit(habit);
            }
            loadHabits();
        } catch (err) {
            alert('Error: ' + err.response?.data?.message || 'Unknown');
        }
    };

    const handleEdit = (habit) => setEditingHabit(habit);

    const handleDelete = async (id) => {
        if (window.confirm("Delete this habit?")) {
            await deleteHabit(id);
            loadHabits();
        }
    };

    return (
        <div>
            <h1>Habit Tracker</h1>
            <HabitForm onSubmit={handleCreateOrUpdate} initialData={editingHabit} />
            <HabitList habits={habits} onEdit={handleEdit} onDelete={handleDelete} />
        </div>
    );
}
