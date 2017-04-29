package by.auto.test.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aleksey.dobrovolsky on 4/29/2017.
 */
public class Contacts extends ForwardingSet<ContactObject> {

    @Override
    protected Set<ContactObject> delegate() {
        return delegate;
    }

    private Set<ContactObject> delegate;

    public Contacts(Contacts contacts) {
        this.delegate = new HashSet<ContactObject>(contacts.delegate);
    }
    public Contacts() {
        this.delegate = new HashSet<ContactObject>();
    }

    public Contacts withAdded (ContactObject contact){
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;
    }

    public Contacts without (ContactObject group){
        Contacts contacts = new Contacts(this);
        contacts.remove(group);
        return contacts;
    }
}
