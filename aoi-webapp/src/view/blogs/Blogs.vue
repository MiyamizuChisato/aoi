<script setup>
import Typography from '../../components/Typography.vue';
import BlogCard from './components/BlogCard.vue';
import { onMounted, ref } from 'vue';
import { sleep } from '../../utils/time.js';
import Visitors from './components/visitors/Visitors.vue';
import Tags from './components/tags/Tags.vue';

const src = ref('');
onMounted(async () => {
    await sleep(500);
    src.value = 'https://cdn.sspai.com/article/5e990d89-61ab-1961-bd4c-cc991d721839.jpg?imageMogr2/auto-orient/quality/95/thumbnail/!800x400r/gravity/Center/crop/800x400/interlace/1';
});
</script>
<template>
    <v-row p-x-lt-md no-gutters>
        <v-col cols='12' lg='8'>
            <typography color='primary'>
                <p text='20px'>全部文章</p>
            </typography>
            <blog-card :src='src' m='b-6' v-for='i in 6' :key='i' />
        </v-col>
        <v-col display='!lt-xl:none' p='!l-12' cols='4'>
            <div>
                <typography color='success'>
                    <p text='20px'>最近来访</p>
                </typography>
                <visitors />
            </div>
            <div position='sticky' top='54px'>
                <typography color='warning'>
                    <p text='20px'>文章标签</p>
                </typography>
                <tags />
            </div>
        </v-col>
    </v-row>
</template>
