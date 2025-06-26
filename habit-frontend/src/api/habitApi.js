import axios from 'axios';

const BASE_URL = 'http://localhost:4000/habits';

export const getHabits = () => axios.get(BASE_URL);
export const createHabit = (data) => axios.post(BASE_URL, data);
export const updateHabit = (id, data) => axios.put(`${BASE_URL}/${id}`, data);
export const deleteHabit = (id) => axios.delete(`${BASE_URL}/${id}`);
