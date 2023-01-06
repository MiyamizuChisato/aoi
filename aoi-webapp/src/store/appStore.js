import { defineStore } from 'pinia';

export const useAppStore = defineStore('app', {
    state() {
        return {
            theme: initTheme()
        };
    },
    getters: {},
    actions: {
        toggleTheme() {
            this.theme = this.theme === 'dark' ? 'light' : 'dark';
            document.documentElement.classList.toggle('dark');
            localStorage.setItem('theme', this.theme);
        }
    }
});
const initTheme = () => {
    let theme = localStorage.getItem('theme');
    if (theme !== 'dark') {
        theme = 'light';
    }
    return theme;
};