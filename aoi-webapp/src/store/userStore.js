import { defineStore } from 'pinia';
import { getProfile } from '../api/user.js';
import { onApiSuccess } from '../utils/assert.js';

export const useUserStore = defineStore('user', {
        state() {
            return {
                token: localStorage.getItem('token'),
                user: null
            };
        },
        getters: {
            signed() {
                return this.user !== null;
            },
            userProfile() {
                return this.user;
            }
        },
        actions: {
            userLogin(token) {
                this.token = token;
            },
            async getUserProfile() {
                const { code, data } = await getProfile();
                onApiSuccess(code, () => {
                    this.user = data;
                });
            }
        }
    })
;