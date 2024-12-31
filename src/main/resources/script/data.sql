CREATE TABLE books(

    book_id serial primary key ,
    title VARCHAR(50) NOT NULL ,
    public_date VARCHAR(40) NOT NULL ,
    author_id bigint unsigned NOT NULL ,
    CONSTRAINT author_fk FOREIGN KEY (author_id)
                  REFERENCES authors(author_id)
                  on UPDATE cascade  on delete cascade



)
SELECT * FROM books;

CREATE TABLE categories(
    categories_id serial primary key ,
    name VARCHAR(255)

);

CREATE TABLE book_category(
    book_id bigint unsigned  not null ,
    category_id  bigint unsigned  NOT NULL ,
    PRIMARY KEY (book_id,category_id),
    CONSTRAINT book_Fk FOREIGN KEY (book_id) REFERENCES books(book_id)
                          on DELETE CASCADE on UPDATE CASCADE,
    CONSTRAINT category_FK FOREIGN KEY (category_id) REFERENCES categories(categories_id)
                          on DELETE CASCADE on UPDATE CASCADE


)




