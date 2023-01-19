import http from '../utils/http.js';
import { sleep } from '../utils/time.js';

const BASE_PATH = '/blog';
export const fetchBlogContent = async (id) => {
    const response = await http.get(`${BASE_PATH}/get/content/${id}`);
    const result = await fetch(response.data);
    await sleep(1000);
    return result.text();
};