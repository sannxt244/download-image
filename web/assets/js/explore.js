function handleCheck(val) {
    const isCheck = document.getElementById(val).checked;
    if (isCheck === true) {
        val.split(',').forEach(tag => {
            tags.push(tag);
        });
        addTags();
    } else {
        document.getElementById(val).checked = false;
        const index = tags.indexOf(val);
        tags = [...tags.slice(0, index), ...tags.slice(index + 1)];
        addTags();
    }
}
const tagContainer = document.querySelector('.tag-container');

let tags = [];

function createTag(label) {
    const div = document.createElement('div');
    div.setAttribute('class', 'tag');
    const span = document.createElement('span');
    span.innerHTML = label;
    const closeIcon = document.createElement('i');
    closeIcon.innerHTML = 'close';
    closeIcon.setAttribute('class', 'material-icons');
    closeIcon.setAttribute('id', 'close-icons');
    closeIcon.setAttribute('data-item', label);
    div.appendChild(span);
    div.appendChild(closeIcon);
    return div;
}

function clearTags() {
    document.querySelectorAll('.tag').forEach(tag => {
        tag.parentElement.removeChild(tag);
    });
}

function addTags() {
    clearTags();
    tags.slice().reverse().forEach(tag => {
        tagContainer.prepend(createTag(tag));
    });
}

document.addEventListener('click', (e) => {
    if (e.target.tagName === 'I') {
        const tagLabel = e.target.getAttribute('data-item');
        console.log(tagLabel);
        document.getElementById(tagLabel).checked = false;
        const index = tags.indexOf(tagLabel);
        tags = [...tags.slice(0, index), ...tags.slice(index + 1)];
        addTags();
    }
});

function submitForms() {
    var x = document.getElementById("mySelect").value;
    console.log(x);
    document.getElementById("orderField").value = x;
    const val = document.getElementById("searchField__raw").value;
    document.getElementById("searchField").value = val;
    document.form.submit();
}

function paging(page) {
    console.log(page);
    document.getElementById("pageField").value  = page;
    submitForms();
}

