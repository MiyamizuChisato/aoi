import { onMounted } from 'vue';
import { forEachMarkdownNode } from '../utils/markdown.js';

export const aosMarkdown = () => {
    onMounted(() => {
        forEachMarkdownNode((node) => {
            if (node.nodeType === 1) {
                node.setAttribute('data-aos', 'animate__fadeInUp');
                node.setAttribute('data-aos-once', 'true');
            }
        });
    });
};