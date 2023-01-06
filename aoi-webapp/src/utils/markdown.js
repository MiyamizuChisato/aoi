export const forEachMarkdownNode = (fun) => {
    document.querySelector('.markdown-body').childNodes.forEach(fun);
};