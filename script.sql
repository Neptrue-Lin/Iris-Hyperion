create table comment_profile
(
    id               bigint unsigned          not null
        primary key,
    target           bigint unsigned          not null,
    author           bigint unsigned          not null,
    content          text                     not null,
    posted_at        datetime default (now()) not null,
    is_deleted       bit      default b'0'    not null,
    last_modified_at datetime default (now()) not null,
    created_at       datetime default (now()) not null
);

create index idx_author
    on comment_profile (author);

create index idx_target
    on comment_profile (target);

create table interaction_metric
(
    id               bigint unsigned          not null
        primary key,
    target           bigint unsigned          not null,
    user_id          bigint unsigned          not null,
    vote             bit                      null,
    reaction         bigint unsigned          null,
    last_modified_at datetime default (now()) not null,
    created_at       datetime default (now()) not null
);

create index idx_target
    on interaction_metric (target);

create index idx_user_id
    on interaction_metric (user_id);

create table user_account
(
    id               bigint unsigned           not null
        primary key,
    password         char(32)                  null,
    is_locked        bit       default b'0'    not null,
    is_cancelled     bit       default b'0'    not null,
    is_deleted       bit       default b'0'    not null,
    last_modified_at timestamp default (now()) not null,
    created_at       timestamp default (now()) not null
);

create table user_identity
(
    id                        bigint unsigned           not null
        primary key,
    user_id                   bigint unsigned           not null,
    identification_claim      varchar(256)              not null,
    is_identification_enabled bit       default b'0'    not null,
    is_verification_enabled   bit       default b'0'    not null,
    is_locked                 bit       default b'0'    not null,
    is_deleted                bit       default b'0'    not null,
    last_modified_at          timestamp default (now()) not null,
    created_at                timestamp default (now()) not null
);

create index idx_identification_claim
    on user_identity (identification_claim);

create index idx_user_id
    on user_identity (user_id);

create table user_profile
(
    id       bigint unsigned not null
        primary key,
    user_id  bigint unsigned not null,
    username varchar(20)     not null,
    avatar   varchar(256)    null,
    birthday datetime        null,
    gender   bit             null
);

create index idx_user_id
    on user_profile (user_id);

create table video_category
(
    id               bigint unsigned          not null
        primary key,
    name             varchar(20)              not null,
    description      text                     null,
    is_deleted       bit      default b'0'    not null,
    last_modified_at datetime default (now()) not null,
    created_at       datetime default (now()) not null
);

create table video_category_profile_manifest
(
    id               bigint unsigned          not null
        primary key,
    video_profile    bigint unsigned          not null,
    video_category   bigint unsigned          not null,
    last_modified_at datetime default (now()) not null,
    created_at       datetime default (now()) not null
);

create index idx_video_category
    on video_category_profile_manifest (video_category);

create index idx_video_profile
    on video_category_profile_manifest (video_profile);

create table video_profile
(
    id               bigint unsigned          not null
        primary key,
    title            varchar(35)              not null,
    author           bigint unsigned          not null,
    cover            varchar(256)             not null,
    creators         bigint unsigned          null,
    category         bigint unsigned          not null,
    tags             bigint unsigned          null,
    description      text                     null,
    published_at     datetime default (now()) not null,
    posted_at        datetime default (now()) not null,
    is_deleted       bit      default b'0'    not null,
    last_modified_at datetime default (now()) not null,
    created_at       datetime default (now()) not null
);

create index idx_author
    on video_profile (author);

create table video_tag
(
    id               bigint unsigned          not null
        primary key,
    name             varchar(20)              not null,
    description      text                     null,
    is_deleted       bit      default b'0'    not null,
    last_modified_at datetime default (now()) not null,
    created_at       datetime default (now()) not null
);

create table video_tag_profile_manifest
(
    id               bigint unsigned          not null
        primary key,
    video_profile    bigint unsigned          not null,
    video_tag        bigint unsigned          not null,
    last_modified_at datetime default (now()) not null,
    created_at       datetime default (now()) not null
);

create index idx_video_profile
    on video_tag_profile_manifest (video_profile);

create index idx_video_tag
    on video_tag_profile_manifest (video_tag);


