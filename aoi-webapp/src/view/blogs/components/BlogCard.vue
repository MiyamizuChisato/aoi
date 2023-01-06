<script setup>
defineProps({
    src: String
});
</script>
<template>
    <div class='blog-card' shadow='sm' rounded='md' flex='md:row col' select='none' bg-container>
        <div class='blog-image'>
            <div class='mask'>
                <div data-aos='animate__fadeInUp' display='md:none' text='14px' text-light>
                    六月 13, 2019
                </div>
            </div>
            <v-img cover h='100%' :src='src'>
                <template #placeholder>
                    <div h='100%' flex-center bg-fill>
                        <v-progress-circular :size='30' text-primary indeterminate />
                    </div>
                </template>
            </v-img>
        </div>
        <div class='blog-info' bg-container flex-between-y>
            <h3 data-aos='animate__fadeInUp' w='100%' m='b-5' md='line-3' lt-md='line-2' pointer strong>
                天涯何处无芳草，高山流水遇知音：我的经典旅游路线</h3>
            <div data-aos='animate__fadeInUp' w='100%' text-secondary flex-between-x>
                <div flex-center>
                    <v-chip m='r-3' size='small' text-regular label>人生之路</v-chip>
                    <div display='lt-md:none' text='14px' text-secondary>六月 13, 2019</div>
                </div>
                <div flex-center>
                    <div m='x-4' flex-center>
                        <i text='4' i-majesticons-lightning-bolt-line />
                        <div m='x-1'>2</div>
                    </div>
                    <div flex-center>
                        <i text='4' i-majesticons-comment-2-line />
                        <div m='x-1'>2</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<style scoped>
@media screen  and (min-width: 768px) {
    .blog-image {
        width: 50%;
        aspect-ratio: 5/3;
    }

    .blog-info {
        width: 50%;
        padding: 30px;
    }

    .blog-card:hover .blog-image {
        transform: scale(1.12);
    }

    .blog-card:hover .mask {
        background-color: rgba(0, 0, 0, 0.1);
    }

    .blog-card:hover .blog-info {
        transform: translateX(-10px);
    }
}

@media screen and (max-width: 768px) {
    .blog-image {
        width: 100%;
        aspect-ratio: 16/9;
    }

    .blog-info {
        padding: 11px;
        width: 100%;
        display: -webkit-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 3;
        overflow: hidden;
    }

    .mask {
        background: linear-gradient(180deg, rgba(49, 49, 48, 0), rgba(22, 29, 39, 0.8));
    }
}

.blog-image {
    position: relative;
    overflow: hidden;
    transition: transform 200ms ease-out;
}

.mask {
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    z-index: 2;
    padding: 11px;
    display: flex;
    align-items: end;
    position: absolute;
    justify-content: end;
    flex-direction: column;
}

.blog-info {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    transition: transform 200ms ease-out;
}

.blog-card {
    display: flex;
    max-width: 800px;
    overflow: hidden;
}
</style>