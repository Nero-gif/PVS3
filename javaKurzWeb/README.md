# PVS3 — Výukový web (statický)

Tento repozitář obsahuje jednoduchý statický výukový web pro kurz PVS3. Web je single-page aplikace, kde se lekce načítají z `data/lessons.json` a zobrazují se v šabloně `index.html`.

Jak používat
1. Naklonuj nebo přidej tyto soubory do repozitáře:
   - `index.html`
   - `assets/styles.css`
   - `assets/app.js`
   - `data/lessons.json`

2. Upravení lekcí
   - Otevři `data/lessons.json` a uprav nebo přidej objekty lekcí (pole objektů). Každá lekce má:
     - `id` (unikátní, použije se v URL po #)
     - `title` (název lekce)
     - `subtitle` (krátký popis)
     - `content` (HTML řetězec s výukovým textem, kódem a cvičeními)
     - `keywords` (volitelné, pro vyhledávání)

3. Lokální test
   - Stačí otevřít `index.html` v prohlížeči. Pokud používáš moderní prohlížeč, některé cross-origin omezení mohou blokovat fetch JSON z file:// — doporučuji spustit jednoduchý server:
     - Python 3: `python -m http.server 8000`
     - Pak otevři: `http://localhost:8000`

4. Deploy na GitHub Pages
   - Vytvoř nový repo nebo použij svůj fork. Nahraj soubory do branch `main` a v repo nastavení povol GitHub Pages (root nebo `/docs`).
   - Alternativa: vytvoř branch `gh-pages` a pushni tam soubory.

Tipy pro rozšíření
- Integruj highlight.js pro zvýraznění kódu.
- Přidej stránku s testy (quiz) a automatické vyhodnocení.
- Můžeš automaticky generovat lekce z obsahu složek `src` v původním repozitáři — pokud chceš, pomohu připravit skript, který z repozitáře vytáhne soubory a vygeneruje `lessons.json`.

Kontakt
- Pokud chceš, mohu:
  - doplnit všech 10+ lekcí plným textem a příklady z repozitáře,
  - generovat cvičné testy z `exams/`,
  - nebo nasadit hotový web do tvého GitHub Pages.

Vytvořil: asistent pro uživatele `Nero-gif`.