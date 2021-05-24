package sample;

import java.io.IOException;
import java.util.List;

public interface GymManager {

    public void addMember();
    public void deleteMember();
    public void printListofMembers();
    public void sort();
    public void save() throws IOException;

}
