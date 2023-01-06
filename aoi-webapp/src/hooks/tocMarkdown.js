import { onMounted, onUnmounted, ref } from 'vue';

export const tocMarkdown = () => {
    let titles;
    let index = 1;
    const select = ref(0);
    const blogToc = ref([]);
    const watcher = new IntersectionObserver(entries => {
        for (const entry of entries) {
            if (entry.isIntersecting) {
                select.value = Number(entry.target.getAttribute('data-index'));
            }
        }
    }, { threshold: 1, rootMargin: `-54px 0px -${window.innerHeight - 154}px 0px` });
    const initToc = () => {
        titles = document.querySelector('.markdown-body').querySelectorAll('h1,h2');
        titles.forEach(title => {
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
    };
    const jumpTrigger = async (index) => {
        for (const title of titles) {
            if (title.getAttribute('data-index') === index.toString()) {
                title.scrollIntoView({
                    behavior: 'smooth'
                });
                select.value = index;
                return;
            }
        }
    };
    onMounted(initToc);
    onUnmounted(() => {
        watcher.disconnect();
    });
    return {
        blogToc, select, titles, jumpTrigger
    };
};