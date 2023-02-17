package az.edu.ada.wm2.librarysystemtask.service;

import az.edu.ada.wm2.librarysystemtask.model.Library;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LibraryServiceImpl implements LibraryService {

    static final List<Library> librarys;

    static {
        librarys = new ArrayList<>();
        librarys.add(new Library(UUID.randomUUID().toString(), "THE HOUSE OF MIRTH ", "The heart of the wise is in the house of mourning; but the heart of fools is in the house of mirth. One of Wharton’s best-known novels","1905","EDITH WHARTON"));
        librarys.add(new Library(UUID.randomUUID().toString(), "EAST OF EDEN ", "The title is suitably grand. Taken from Genesis, the first book of the Old Testament, it refers to line 4:16, after Cain has slain his brother Abel. And Cain went out from the presence of the Lord, and dwelt in the land of Nod, on the east of Eden.","1952","JOHN STEINBECK"));
        librarys.add(new Library(UUID.randomUUID().toString(), "THE SUN ALSO RISES ", "More Ecclesiastes! This particular quotation is from 1:5, which states that The sun also ariseth, and the sun goeth down, and hasteth to his place where he arose.","1926","ERNEST HEMINGWAY"));
    }

    @Override
    public List<Library> list() {
        return librarys;
    }

    @Override
    public Library getById(String id) {
        Optional<Library> result = librarys.stream()
                .filter(library -> library.getId().equals(id))
                .findAny();
        return result.orElse(new Library());
    }

    @Override
    public Library save(Library library) {
        if (library.getId() == null) {
            library.setId(UUID.randomUUID().toString());
            librarys.add(library);

            return library;
        }


        Optional<Library> result = librarys.stream()
                .filter(p -> p.getId().equals(library.getId()))
                .findAny();

        Library oldRecord = result.orElseThrow();

        oldRecord.setTitle(library.getTitle());
        oldRecord.setDescription(library.getDescription());
        oldRecord.setYear(library.getYear());
        oldRecord.setAuthor(library.getAuthor());


        return oldRecord;
    }

    @Override
    public void deleteById(String id) {
        Optional<Library> result = librarys.stream()
                .filter(library -> library.getId().equals(id))
                .findAny();

        if (result.isPresent())
            librarys.remove(result.get());
    }


}