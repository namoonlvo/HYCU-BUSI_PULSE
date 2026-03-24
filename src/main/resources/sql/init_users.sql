-- =====================================================
-- 테이블은 이미 생성돼 있으므로 INSERT만 실행하세요
-- Supabase SQL Editor에서 실행
-- =====================================================

-- 테스트 계정 삽입 (login_id: admin / 비밀번호: admin1234)
-- password_hash 는 "admin1234" 를 BCrypt 처리한 값
INSERT INTO public.user (
    user_id,
    login_id,
    password_hash,
    user_name,
    email,
    use_yn,
    role_code,
    rgdt
)
VALUES (
    gen_random_uuid(),
    'admin',
    '$2a$10$7EqJtq98hPqEX7fNZaFWoOa.lNpjvRL5MAtNKiDEDJyDkMdNOhWCa',
    '관리자',
    'admin@hycu.ac.kr',
    'Y',
    1,
    NOW()
)
ON CONFLICT (login_id) DO NOTHING;
