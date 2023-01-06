<script setup>
import DefaultHeaderMenu from './DefaultHeaderMenu.vue';
import DefaultHeaderPrefix from './DefaultHeaderPrefix.vue';
import DefaultHeaderSuffix from './DefaultHeaderSuffix.vue';
</script>
<template>
    <header data-aos='animate__fadeInDown' shadow='sm' data-aos-once='true'
            position='sticky' top='0' h='54px' z='10' flex-center bg-container>
        <default-header-prefix left='24' position='absolute' />
        <default-header-menu />
        <default-header-suffix right='24' position='absolute' />
    </header>
</template>

