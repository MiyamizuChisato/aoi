<script setup>

import Tag from './Tag.vue';
import { sleep } from '../../../../utils/time.js';

await sleep(1000);
</script>
<template>
    <div rounded='1' p='12px' data-aos='animate__fadeIn' flex flex-wrap bg-container>
        <tag tag='人生之路' />
        <tag tag='无名之辈' />
        <tag tag='致我' />
        <tag tag='致世界' />
        <tag tag='游戏狂魔' />
        <tag tag='能量充电' />
        <tag tag='ACG' />
        <tag tag='真理的门' />
    </div>
</template>
