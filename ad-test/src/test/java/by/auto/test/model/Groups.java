package by.auto.test.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aleksey.dobrovolsky on 4/29/2017.
 */
public class Groups extends ForwardingSet<GroupObject>{


    @Override
    protected Set<GroupObject> delegate() {
        return delegate;
    }

    private Set<GroupObject> delegate;

    public Groups(Groups groups) {
        this.delegate = new HashSet<GroupObject>(groups.delegate);
    }
    public Groups() {
        this.delegate = new HashSet<GroupObject>();
    }

    public Groups withAdded (GroupObject group){
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;
    }

    public Groups without (GroupObject group){
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }
}
