use opensource;
create table myVideo
(
    myVideo_id    bigint       not null auto_increment,
    created_date  datetime     not null,
    myVideo_title VARCHAR(255) not null,
    primary key (myVideo_id)
) engine = InnoDB;