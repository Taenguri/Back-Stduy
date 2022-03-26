
create table board(
    board_idx number(4) primary key,
    board_name varchar2(200),
    board_title varchar2(200),
    board_content varchar2(200),
    board_date date default sysdate,
    board_hit number(4) default 0
    );
    
create sequence board_seq;

insert into board(board_idx, board_name, board_title, board_content, board_date)
values(board_seq.nextval, '홍길동', '제목', '내용', sysdate);

create table reply(
    reply_idx number(4) primary key,
    reply_name varchar2(200),
    reply_content varchar2(300),
    reply_date date default sysdate,
    reply_board_idx number(4)
    );
    
create sequence reply_board_seq;

insert into reply(reply_idx, reply_name, reply_content, reply_date , reply_board_idx)
values(reply_board_seq.nextval, '홍댓글',  '댓글내용', sysdate,1);
commit;