const lessonsUrl = 'data_lessons.json';
let lessons = [];

function el(tag, cls, text){
  const e = document.createElement(tag);
  if(cls) e.className = cls;
  if(text !== undefined) e.textContent = text;
  return e;
}

async function loadLessons(){
  try{
    const res = await fetch(lessonsUrl);
    lessons = await res.json();
    renderList(lessons);
    handleRouting();
    setupSearch();
    window.addEventListener('hashchange', handleRouting);
  }catch(e){
    document.getElementById('lessonContent').innerHTML = '<p>Chyba: Nepodařilo se načíst data lekcí.</p>';
    console.error(e);
  }
}

function renderList(items){
  const list = document.getElementById('lessonsList');
  list.innerHTML = '';
  items.forEach(ls => {
    const a = el('a','lesson-item');
    a.href = `#${ls.id}`;
    a.innerHTML = `<div class="lesson-title">${escapeHtml(ls.title)}</div><div class="lesson-meta">${escapeHtml(ls.subtitle || '')}</div>`;
    list.appendChild(a);
  });
}

function renderLesson(id){
  const lesson = lessons.find(l=>l.id===id);
  const target = document.getElementById('lessonContent');
  if(!lesson){
    target.innerHTML = `<h2>Vítej</h2><p>Vyber lekci z levého menu.</p>`;
    return;
  }

  // vytvoříme kontejner a vložíme HTML z lessons.json
  const container = document.createElement('div');
  // POZOR: lesson.content může obsahovat HTML (text + <pre class="code">...</pre>)
  // nastavíme innerHTML, ale následně zajistíme, že obsah v <pre class="code"> bude skutečný text (textContent)
  container.innerHTML = `<h2>${escapeHtml(lesson.title)}</h2><p class="muted">${escapeHtml(lesson.subtitle || '')}</p>${lesson.content}`;

  // Najdeme všechny <pre class="code"> a převedeme jejich vnitřek do textContent
  // Tímto krokem zajistíme, že se vykreslí přesné znaky (<, >, &) a přesné odřádkování.
  container.querySelectorAll('pre.code').forEach(pre => {
    // pokud byl v JSON použit HTML-escaped obsah (&lt;, &gt;, &amp;), innerHTML obsahuje ty entity
    // převedeme innerHTML na text tak, že si jej necháme jako text (decode entities) a nastavíme textContent
    const htmlInside = pre.innerHTML;
    const decoded = decodeHtmlEntities(htmlInside);
    pre.textContent = decoded;
  });

  // Vložíme vykreslený obsah do stránky
  target.innerHTML = '';
  target.appendChild(container);

  // scroll top
  document.getElementById('content').scrollIntoView({behavior:'smooth'});
}

function handleRouting(){
  const hash = location.hash.replace('#','');
  if(!hash){
    renderLesson('');
    return;
  }
  renderLesson(hash);
}

// jednoduché vyhledávání
function setupSearch(){
  const input = document.getElementById('search');
  input.addEventListener('input', (e)=>{
    const q = e.target.value.toLowerCase();
    const filtered = lessons.filter(l => (l.title + ' ' + (l.subtitle||'') + ' ' + (l.keywords||'')).toLowerCase().includes(q));
    renderList(filtered);
  });
}

// helpery
function decodeHtmlEntities(str){
  // dekóduje základní HTML entity ve stringu (v případě, že jsou v lesson.content)
  return str.replace(/&lt;/g, '<').replace(/&gt;/g, '>').replace(/&amp;/g, '&');
}

function escapeHtml(str){
  return String(str)
    .replace(/&/g, '&amp;')
    .replace(/</g, '&lt;')
    .replace(/>/g, '&gt;')
    .replace(/"/g, '&quot;')
    .replace(/'/g, '&#39;');
}

loadLessons();