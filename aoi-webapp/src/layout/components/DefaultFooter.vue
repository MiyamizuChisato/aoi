<script setup>

</script>
<template>
    <footer text-center text-secondary flex-center flex-col>
        <p class='sakura'>
            <i i-twemoji-cherry-blossom />
        </p>
        <p>
            1.感谢自己
        </p>
        <p>2.感谢家人</p>
        <p>3.感谢朋友</p>
        <p>4.感谢老师</p>
    </footer>
</template>
<style scoped>
footer {
    margin-top: 60px;
    padding: 20px 120px;
}

.sakura {
    opacity: 0.4;
    animation: rotate 10s linear 0ms infinite;
}

p {
    margin-top: 4px;
}

@keyframes rotate {
    0% {
        transform: rotate(0deg);
    }
    100% {
        transform: rotate(360deg);
    }
}
</style>
