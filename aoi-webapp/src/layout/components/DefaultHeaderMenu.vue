<script setup>
import { computed } from 'vue';
import { useRouter } from 'vue-router';
import { go } from '../../utils/router.js';

const router = useRouter();
const toggle = computed(() => router.currentRoute.value);
</script>
<template>
    <v-btn-toggle selected-class='selected' v-model='toggle.name' rounded='0' h='!54px' mandatory>
        <v-btn @click='go("/home")' class='btn-menu' value='home' bg='!transparent' m='!x-2' p='!x-7' flat>
            <span text-strong>主页</span>
        </v-btn>
        <v-btn @click='go("/blogs")' class='btn-menu' value='blogs' bg='!transparent' m='!x-2' p='!x-7' flat>
            <span text-strong>博客</span>
        </v-btn>
        <v-btn @click='go("/messages")' class='btn-menu' value='messages' bg='!transparent' m='!x-2' p='!x-7' flat>
            <span text-strong>留言</span>
        </v-btn>
        <v-btn @click='go("/friends")' class='btn-menu' value='friends' bg='!transparent' m='!x-2' p='!x-7' flat>
            <span text-strong>友邻</span>
        </v-btn>
    </v-btn-toggle>
</template>
<style scoped>
.btn-menu {
    transition: none;
}

.btn-menu:hover {
    background-color: var(--c-hover) !important;
}

:deep(button.v-btn--active) {
    background-color: var(--c-selected) !important;
}
</style>