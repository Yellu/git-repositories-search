package com.github.search.fastadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.search.R;
import com.github.search.database.LicenseEntity;
import com.github.search.database.OwnerEntity;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.items.AbstractItem;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class RealmSampleUserItem extends RealmObject implements IItem<RealmSampleUserItem, RealmSampleUserItem.ViewHolder> {
    @PrimaryKey
    public int id;
    public String name;
    public String full_name;
    public OwnerEntity owner;
    public boolean _private;
    public String html_url;
    public String description;
    public Boolean fork;
    public String url;
    public String forks_url;
    public String keys_url;
    public String collaborators_url;
    public String teams_url;
    public String hooks_url;
    public String issue_events_url;
    public String events_url;
    public String assignees_url;
    public String branches_url;
    public String tags_url;
    public String blobs_url;
    public String git_tags_url;
    public String git_refs_url;
    public String trees_url;
    public String statuses_url;
    public String languages_url;
    public String stargazers_url;
    public String contributors_url;
    public String subscribers_url;
    public String subscription_url;
    public String commits_url;
    public String git_commits_url;
    public String comments_url;
    public String issue_comment_url;
    public String contents_url;
    public String compare_url;
    public String merges_url;
    public String archive_url;
    public String downloads_url;
    public String issues_url;
    public String pulls_url;
    public String milestones_url;
    public String notifications_url;
    public String labels_url;
    public String releases_url;
    public String deployments_url;
    public String created_at;
    public String updated_at;
    public String pushed_at;
    public String git_url;
    public String ssh_url;
    public String clone_url;
    public String svn_url;
    //    public Object homepage;
    public int size;
    public int stargazers_count;
    public int watchers_count;
    public String language;
    public boolean has_issues;
    public boolean has_projects;
    public boolean has_downloads;
    public boolean has_wiki;
    public boolean has_pages;
    public int forks_count;
    //    public Object mirror_url;
    public boolean archived;
    public int open_issues_count;
    public LicenseEntity license;
    public int forks;
    public int open_issues;
    public int watchers;
    public String default_branch;
    public float score;
    public Date createdAt;

    // Standard getters & setters generated by your IDE…
    public String getName() {
        return name;
    }

    /**
     * set the name of this item
     *
     * @param name
     * @return this
     */
    public RealmSampleUserItem withName(String name) {
        this.name = name;
        return this;
    }

//    // the identifier for this item
//    @PrimaryKey
//    protected long mIdentifier = -1;

    /**
     * set the identifier of this item
     *
     * @param identifier
     * @return this
     */
    public RealmSampleUserItem withIdentifier(long identifier) {
        this.id = (int) identifier;
        return this;
    }

    /**
     * @return the identifier of this item
     */
    @Override
    public long getIdentifier() {
        return id;
    }

    // the tag for this item
    @Ignore
    protected Object mTag;

    /**
     * set the tag of this item
     *
     * @param object
     * @return this
     */
    public RealmSampleUserItem withTag(Object object) {
        this.mTag = object;
        return this;
    }

    /**
     * @return the tag of this item
     */
    @Override
    public Object getTag() {
        return mTag;
    }

    // defines if this item is enabled
    @Ignore
    protected boolean mEnabled = true;

    /**
     * set if this item is enabled
     *
     * @param enabled true if this item is enabled
     * @return this
     */
    public RealmSampleUserItem withEnabled(boolean enabled) {
        this.mEnabled = enabled;
        return this;
    }

    /**
     * @return if this item is enabled
     */
    @Override
    public boolean isEnabled() {
        return mEnabled;
    }

    // defines if the item is selected
    @Ignore
    protected boolean mSelected = false;

    /**
     * set if this item is selected
     *
     * @param selected true if this item is selected
     * @return this
     */
    @Override
    public RealmSampleUserItem withSetSelected(boolean selected) {
        this.mSelected = selected;
        return this;
    }

    /**
     * @return if this item is selected
     */
    @Override
    public boolean isSelected() {
        return mSelected;
    }

    // defines if this item is selectable
    @Ignore
    protected boolean mSelectable = true;

    /**
     * set if this item is selectable
     *
     * @param selectable true if this item is selectable
     * @return this
     */
    @Override
    public RealmSampleUserItem withSelectable(boolean selectable) {
        this.mSelectable = selectable;
        return this;
    }

    /**
     * @return if this item is selectable
     */
    @Override
    public boolean isSelectable() {
        return mSelectable;
    }

    /**
     * returns the type of the Item. Can be a hardcoded INT, but preferred is a defined id
     *
     * @return
     */
    @Override
    public int getType() {
        return R.id.fastadapter_realm_sample_user_item_id;
    }

    /**
     * returns the layout for the given item
     *
     * @return
     */
    @Override
    public int getLayoutRes() {
        return R.layout.repo_list_item;
    }

    /**
     * generates a view by the defined LayoutRes
     *
     * @param ctx
     * @return
     */
    @Override
    public View generateView(Context ctx) {
        ViewHolder viewHolder = getViewHolder(LayoutInflater.from(ctx).inflate(getLayoutRes(), null, false));

        //as we already know the type of our ViewHolder cast it to our type
        bindView(viewHolder, Collections.EMPTY_LIST);

        //return the bound view
        return viewHolder.itemView;
    }

    /**
     * generates a view by the defined LayoutRes and pass the LayoutParams from the parent
     *
     * @param ctx
     * @param parent
     * @return
     */
    @Override
    public View generateView(Context ctx, ViewGroup parent) {
        ViewHolder viewHolder = getViewHolder(LayoutInflater.from(ctx).inflate(getLayoutRes(), parent, false));

        //as we already know the type of our ViewHolder cast it to our type
        bindView(viewHolder, Collections.EMPTY_LIST);
        //return the bound and generatedView
        return viewHolder.itemView;
    }

    /**
     * Generates a ViewHolder from this Item with the given parent
     *
     * @param parent
     * @return
     */
    @Override
    public ViewHolder getViewHolder(ViewGroup parent) {
        return getViewHolder(LayoutInflater.from(parent.getContext()).inflate(getLayoutRes(), parent, false));
    }

    /**
     * This method returns the ViewHolder for our item, using the provided View.
     *
     * @param v
     * @return the ViewHolder for this Item
     */
    private ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    /**
     * Binds the data of this item to the given holder
     *
     * @param holder
     */
    @Override
    public void bindView(ViewHolder holder, List<Object> payloads) {
        //set the selected state of this item. force this otherwise it may is missed when implementing an item
        holder.itemView.setSelected(isSelected());

        //set the name
        holder.tvName.setText(name);
    }

    @Override
    public void unbindView(ViewHolder holder) {
        holder.tvName.setText(null);
    }

    @Override
    public void attachToWindow(ViewHolder holder) {}

    @Override
    public void detachFromWindow(ViewHolder holder) {}

    @Override
    public boolean failedToRecycle(ViewHolder holder) {
        return false;
    }

    /**
     * If this item equals to the given identifier
     *
     * @param id identifier
     * @return true if identifier equals id, false otherwise
     */
    @Override
    public boolean equals(int id) {
        return id == getIdentifier();
    }

    /**
     * If this item equals to the given object
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractItem<?, ?> that = (AbstractItem<?, ?>) o;
        return getIdentifier() == that.getIdentifier();
    }

    /**
     * the hashCode implementation
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Long.valueOf(getIdentifier()).hashCode();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvName) TextView tvName;
        @BindView(R.id.tvFullName) TextView tvFullName;
        @BindView(R.id.tvWatcherCount) TextView tvWatcherCount;
        @BindView(R.id.tvCommitCount) TextView tvCommitCount;
        @BindView(R.id.thumbnail) ImageView imageView;
        @BindView(R.id.tvStarCount) TextView tvStarCount;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}