# AeroParker Web Registration

Author: **Elza Contiero**


## Database structure

```sql
create table customer
(
    id             int auto_increment primary key,
    registered     datetime not null,
    email_address  varchar(255) unique not null,
    title          varchar(5),
    first_name     varchar(50) not null,
    last_name      varchar(50) not null,
    address_line_1 varchar(255) not null,
    address_line_2 varchar(255) null,
    city           varchar(255) not null,
    postcode       varchar(10),
    phone_number   varchar(20)
);
```

