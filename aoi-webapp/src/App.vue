<script setup>
import { ref } from 'vue';
import ReturnTop from './components/ReturnTop.vue';

const tips = ref(false);
</script>
<template>
    <v-snackbar timeout='5000' v-model='tips'>
        网站优化了一些页面的滚使动条数据，用浏览器的前进和后退（或者你正好使用鼠标侧键），获得更好的体验
        <template v-slot:actions>
            <v-btn color='pink' variant='text' @click='tips = false'>
                关 闭
            </v-btn>
        </template>
    </v-snackbar>
    <return-top />
    <router-view />
</template>
