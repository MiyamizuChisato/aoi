import http from '../utils/http.js';

const BASE_PATH = '/user';
export const getProfile = async () => {
    return await http.get(`${BASE_PATH}/get/profile`);
};