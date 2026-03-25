/* ── 로그아웃 ── */
function logoutAction() {
  const csrfToken = document.querySelector('meta[name="_csrf"]').content;
  const csrfParam = document.querySelector('meta[name="_csrf_parameter"]').content;
  const form = document.createElement('form');
  form.method = 'POST';
  form.action = '/logout';
  const input = document.createElement('input');
  input.type = 'hidden';
  input.name = csrfParam;
  input.value = csrfToken;
  form.appendChild(input);
  document.body.appendChild(form);
  form.submit();
}

/* ── 사이드바 토글 ── */
function toggleSidebar() {
  const sidebar = document.getElementById('sidebar');
  const wrapper = document.getElementById('main-wrapper');
  sidebar.classList.toggle('collapsed');
  wrapper.classList.toggle('collapsed');
}

/* ── 서브메뉴 토글 ── */
function toggleSubmenu(el) {
  const submenu = el.querySelector('.submenu');
  if (!submenu) return;
  const isOpen = el.classList.contains('open');
  if (isOpen) {
    el.classList.remove('open');
    submenu.classList.remove('open');
  } else {
    el.classList.add('open');
    submenu.classList.add('open');
  }
}

/* ── 드롭다운 패널 토글 ── */
function togglePanel(id) {
  const panel = document.getElementById(id);
  const overlay = document.getElementById('overlay');
  const isVisible = panel.classList.contains('show');

  closeAllPanels();

  if (!isVisible) {
    panel.classList.add('show');
    overlay.style.display = 'block';
  }
}

function closeAllPanels() {
  document.querySelectorAll('#notification-panel, #profile-panel').forEach(p => p.classList.remove('show'));
  document.getElementById('overlay').style.display = 'none';
}
