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
  if (!el) return;
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

/* ── GNB 브레드크럼 + 사이드바 활성화 ── */
document.addEventListener('DOMContentLoaded', function () {
  const path = window.location.pathname.replace(/\/$/, '');

  // [대메뉴, 중메뉴]
  const pageMap = {
    '/dashboard/main':      ['대시보드',       '종합 대시보드'],
    '/dashboard/summary':   ['대시보드',       '성과 요약'],
    '/schedule/calendar':   ['일정관리',       '통합 캘린더'],
    '/schedule/list':       ['일정관리',       '일정 관리'],
    '/leave/manage':        ['일정관리',       '휴가/외근 관리'],
    '/project/master':      ['프로젝트 관리',  '프로젝트 마스터'],
    '/project/wbs_manage':  ['프로젝트 관리',  'WBS 관리'],
    '/project/document':    ['프로젝트 관리',  '프로젝트 문서'],
    '/task/my_list':        ['내 업무',        '업무 리스트'],
    '/task/history':        ['내 업무',        '업무 히스토리'],
    '/report/performance':  ['성과 리포트',    '성과 분석'],
    '/board/notice':        ['협업 & 게시판',  '공지 및 지침'],
    '/board/meeting':       ['협업 & 게시판',  '회의 보고서'],
    '/admin/user_manage':   ['시스템 관리',    '사용자/권한 관리'],
    '/admin/code_manage':   ['시스템 관리',    '공통 코드 관리'],
  };

  // 브레드크럼 업데이트
  const parentEl = document.getElementById('gnb-parent-title');
  const pageEl   = document.getElementById('gnb-page-title');
  const entry = pageMap[path];
  if (parentEl && pageEl && entry) {
    parentEl.textContent = entry[0];
    pageEl.textContent   = entry[1];
  }

  // 사이드바 현재 페이지 메뉴 자동 오픈
  const sidebar = document.getElementById('sidebar');
  if (!sidebar) return;

  // 모든 서브메뉴 닫기
  sidebar.querySelectorAll('.has-submenu').forEach(el => {
    el.classList.remove('open');
    const sm = el.querySelector('.submenu');
    if (sm) sm.classList.remove('open');
  });

  // 현재 URL과 일치하는 링크의 부모 서브메뉴 열기
  const activeLink = Array.from(sidebar.querySelectorAll('a[href]'))
    .find(a => a.getAttribute('href') === path);
  if (activeLink) {
    const parentMenu = activeLink.closest('.has-submenu');
    if (parentMenu) {
      parentMenu.classList.add('open');
      const sm = parentMenu.querySelector('.submenu');
      if (sm) sm.classList.add('open');
    }
  }
});
