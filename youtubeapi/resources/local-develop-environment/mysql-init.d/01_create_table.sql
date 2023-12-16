use opensource;
create table my_video
(
    my_video_id    bigint       not null auto_increment,
    created_date   datetime     not null,
    my_video_title VARCHAR(255) not null,
    primary key (my_video_id)
) engine = InnoDB;

create table day_history
(
    day_history_id   bigint       not null auto_increment,
    day_history_noun VARCHAR(255) not null,
    day_history_date date         not null,
    primary key (day_history_id)
) engine = InnoDB;