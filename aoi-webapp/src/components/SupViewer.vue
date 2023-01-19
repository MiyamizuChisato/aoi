<script setup>
import { inject } from 'vue';

const editor = inject('editor');
const reply = () => {
    editor.value.replyHandler('Tisato', 0, 1);
};
</script>
<template>
    <div flex-between-x>
        <div flex-center-x>
            <v-avatar size='36'
                      image='https://oss-cdn.yevpt.com/avatar/user/c4bcd6962b5344c3a35ce18b7ed55068.jpg?a=ea2e24517e57d717bef3d3e9f259104d&b=63aec822' />
            <div m='x-2'>
                <div font='500' text='15px' text-strong>Tisato</div>
                <div text='12px' text-secondary>2023-01-05 20:21</div>
            </div>
        </div>
        <v-btn @click='reply' size='small' color='transparent' variant='flat'>
            <span text-secondary>回复</span>
        </v-btn>
    </div>
    <div m='y-2' text='14px' data-aos-once='true' data-aos='animate__fadeInUp' text-regular>
        无言独上西楼，月如钩。寂寞梧桐深院锁清秋。
    </div>
</template>
