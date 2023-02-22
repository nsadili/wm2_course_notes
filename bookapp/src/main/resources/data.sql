TRUNCATE TABLE book;
INSERT
  INTO
      book (
            `title`,
            `description`,
            `year`,
            `author`
  )
  VALUES (
        'Nineteen Eighty-Four',
        'Nineteen Eighty-Four is a dystopian social science fiction novel and cautionary tale by English writer George Orwell. It was published on 8 June 1949 by Secker & Warburg as Orwell''s ninth and final book completed in his lifetime.',
        1949,
        'George Orwell'
  ), (
        'War and Peace',
        'War and Peace is a literary work by the Russian author Leo Tolstoy that mixes fictional narrative with chapters on history and philosophy. It was first published serially, then published in its entirety in 1869.',
        1869,
        'Lev Tolstoi'
  );