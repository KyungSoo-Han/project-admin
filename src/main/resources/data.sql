-- 테스트 계정
-- TODO: 테스트용이지만 비밀번호가 노출된 데이터 세팅. 개선하는 것이 좋을 지 고민해 보자.
insert into admin_account (user_id, password, role_types, nickname, email, memo, created_at, created_by, modified_at, modified_by) values
  ('admin', '{noop}1234', 'ADMIN', 'Admin', 'admin@mail.com', 'I am Admin.', now(), 'admin', now(), 'admin'),
  ('mark', '{noop}asdf1234', 'MANAGER', 'Mark', 'mark@mail.com', 'I am Mark.', now(), 'admin', now(), 'admin'),
  ('susan', '{noop}asdf1234', 'MANAGER,DEVELOPER', 'Susan', 'Susan@mail.com', 'I am Susan.', now(), 'admin', now(), 'admin'),
  ('jim', '{noop}asdf1234', 'USER', 'Jim', 'jim@mail.com', 'I am Jim.', now(), 'admin', now(), 'admin')
;

insert into business (business_id, created_at, created_by, modified_at, modified_by, address, biz_number, memo, name, owner_name, phone_number)
values(1, now(), 'admin', now(), 'admin', '수원시 장안구 화산로', '100-22-33049', '첫번째 사업장', '오늘의떡케이크', '한경수', '010-9171-6166' );

insert into item(item_id, created_at, created_by, modified_at, modified_by, item_name, item_type, memo, unit, business_id)
values(1,now(),'admin',now(),'admin',1,'PRODUCT',1,1,1),
      (2,now(),'admin',now(),'admin',2,'PRODUCT',2,2,1),
      (3,now(),'admin',now(),'admin',3,'PRODUCT',3,3,1),
      (4,now(),'admin',now(),'admin',4,'PRODUCT',4,4,1),
      (5,now(),'admin',now(),'admin',5,'PRODUCT',5,5,1),
      (6,now(),'admin',now(),'admin',6,'PRODUCT',6,6,1),
      (7,now(),'admin',now(),'admin',7,'PRODUCT',7,7,1),
      (8,now(),'admin',now(),'admin',8,'PRODUCT',8,8,1),
      (9,now(),'admin',now(),'admin',9,'PRODUCT',9,9,1),
      (10,now(),'admin',now(),'admin',10,'PRODUCT',10,10,1),
      (111,now(),'admin',now(),'admin',11,'PRODUCT',11,11,1);
