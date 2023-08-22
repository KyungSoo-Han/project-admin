-- 테스트 계정
-- TODO: 테스트용이지만 비밀번호가 노출된 데이터 세팅. 개선하는 것이 좋을 지 고민해 보자.
insert into admin_account (user_id, password, role_types, nickname, email, memo, created_at, created_by, modified_at, modified_by) values
  ('admin', '{noop}1234', 'ADMIN', 'Admin', 'admin@mail.com', 'I am Admin.', now(), 'admin', now(), 'admin'),
  ('mark', '{noop}asdf1234', 'MANAGER', 'Mark', 'mark@mail.com', 'I am Mark.', now(), 'admin', now(), 'admin'),
  ('susan', '{noop}asdf1234', 'MANAGER,DEVELOPER', 'Susan', 'Susan@mail.com', 'I am Susan.', now(), 'admin', now(), 'admin'),
  ('jim', '{noop}asdf1234', 'USER', 'Jim', 'jim@mail.com', 'I am Jim.', now(), 'admin', now(), 'admin')
;

insert into business (business_id, created_at, created_by, modified_at, modified_by, address, biz_number, memo, name, owner_name, phone_number)
values(1, now(), 'admin', now(), 'admin', '수원시 장안구 화산로', '100-22-33049', '첫번째 사업장', '오늘의떡케이크', '한경수', '010-9171-6166' )
