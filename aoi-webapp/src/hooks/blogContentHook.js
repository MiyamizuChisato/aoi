import { onMounted, onUnmounted, provide, ref } from 'vue';
import { forEachMarkdownNode, forEachMarkdownTitle } from '../utils/markdown.js';
import { styleToggle } from '../utils/codeStyle.js';
import Aos from 'aos';

export const blogContentHook = () => {
    const select = ref(0);
    const blogToc = ref([]);
    const codeStyle = styleToggle();
    const jumpTrigger = async (index) => {
        forEachMarkdownTitle(title => {
            if (title.getAttribute('data-index') === index.toString()) {
                title.scrollIntoView({
                    behavior: 'smooth'
                });
                return;
            }
        });
    };
    const watcher = new IntersectionObserver(entries => {
        for (const entry of entries) {
            if (entry.isIntersecting) {
                select.value = Number(entry.target.getAttribute('data-index'));
            }
        }
    }, { threshold: 1, rootMargin: `-54px 0px -${window.innerHeight - 200}px 0px` });
    provide('jumpTrigger', jumpTrigger);
    onMounted(() => {
        let index = 1;
        forEachMarkdownNode((node) => {
            if (node.nodeType === 1) {
                node.setAttribute('data-aos', 'animate__fadeInUp');
            }
        });
        Aos.init();
        forEachMarkdownTitle(title => {
            title.setAttribute('data-index', index.toString());
            const node = {
                index, text: title.innerHTML
            };
            if (title.tagName === 'H1') {
                const supNode = {
                    ...node, children: []
                };
                blogToc.value.push(supNode);
            } else {
                blogToc.value[blogToc.value.length - 1].children.push(node);
            }
            watcher.observe(title);
            index += 1;
        });
    });
    onUnmounted(() => {
        watcher.disconnect();
        codeStyle();
    });
    return { blogToc, select };
};