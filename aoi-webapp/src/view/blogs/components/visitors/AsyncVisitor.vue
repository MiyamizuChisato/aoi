<script setup>
import Visitor from './Visitor.vue';
import { ref } from 'vue';
import { sleep } from '../../../../utils/time.js';

const src = ref('');
await sleep(2000);
src.value = 'https://oss-cdn.yevpt.com/avatar/user/c4bcd6962b5344c3a35ce18b7ed55068.jpg?a=ea2e24517e57d717bef3d3e9f259104d&b=63aec822';
</script>
<template>
    <v-row select='none' data-aos='animate__fadeIn' data-aos-once='true' p='12px' rounded='1'
           flex flex-wrap bg-container no-gutters>
        <v-col cols='4' v-for='i in 9' :key='i'>
            <visitor :src='src' />
        </v-col>
    </v-row>
</template>

<style scoped>

</style>