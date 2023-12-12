use opensource;
create table my_video
(
    my_video_id    bigint       not null auto_increment,
    created_date  datetime     not null,
    my_video_title VARCHAR(255) not null,
    primary key (myVideo_id)
) engine = InnoDB;