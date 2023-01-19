<script setup>
import 'element-plus/lib/components/skeleton/style/css';
import { ElSkeleton } from 'element-plus';
</script>
<template>
    <div p='30px' class='loading-blog-content' rounded='md:b-sm' bg-container>
        <el-skeleton :rows='12' :throttle='100' data-aos='animate__fadeIn' animated />
    </div>
    <div class='loading-blog-toc' display='xl:block lt-xl:none' position='fixed' top='80'>
        <el-skeleton :rows='4' :throttle='100' data-aos='animate__fadeIn' animated />
    </div>
</template>
<style scoped>
.loading-blog-content {
    min-height: 300px;
}

.loading-blog-toc {
    bottom: 0;
    right: 70px;
    font-size: 12px;
    position: fixed;
    user-select: none;
    overflow-y: scroll;
    width: 220px;
    padding-right: 20px;
}
</style>