# Description

<describe here your changes, what you're fixing, etc>

**[Architecture Design Document](https://github.com/pedromews/ihc)**:  [description](link)

# Definition of Done Checklist

Before, setting the PR to **Ready to review**, make sure to meet the Definition of Done criteria bellow:

The proper **tracking** of the change is done :
- [ ] Naming the PR's title with Jira item's suffix (e.g. _NGP-1234/Title_).
- [ ] If applicable, setting the POM version and updating [changelog](/README.md).  
  Use `mvn versions:set -DnewVersion:x.x.x` and `mvn versions:commit`, or run the [Version Updater](https://github.com/pedromews/ihc).
- [ ] Traceability linking has been added to relevant tests ([more information](https://github.com/pedromews/ihc)).

If you are delivering or updating an **entity**, make sure the following checks have been performed:

- [ ] Use `@Column(updatable = false)` for immutable fields and add `@RetentionPeriod` to root entities, [see more here](https://github.com/pedromews/ihc).
- [ ] Update API Views according to entities' changes. This may impact UIs and other services, in this case raise the flag!
- [ ] Java docs added to outbound events and entities.
- [ ] Input Validation annotations have been added to API fields ([more information](https://github.com/pedromews/ihc)).

🚨: If you are making a database change, make sure the following checks have been performed: 🚨:

- [ ] :page_facing_up: Database files updated according to changes, remember to follow the [guide](https://github.com/pedromews/ihc) for adding new columns.
- [ ] :no_entry_sign: Merge the PR only after 14:00 BRT and if there is a succesfully built vector!
- [ ] :white_check_mark: After the PR is released, execute our E2E tests (ALL_CAN) in Dev/XAllFeaturesEU10004 and monitor the DwC deployment, migration, and activation of the new vector.

If you are delivering a new use of **another service's API**, make sure the following checks have been performed:

- [ ] Contract test are in place and maintained ([more information](https://github.com/pedromews/ihc)).

If you are delivering a new **command executor** or an **event handler**, make sure the following checks have been performed:

- [ ] Configure Executors and Handlers annotations properties (e.g. `routingContext`, `nextAtomicProcessTrigger`, `mandatory`) ([more information](https://github.com/pedromews/ihc)).

It was **built and tested** by:

- [ ] Testing locally with the latest version of the code.
- [ ] [Run mutation testing](https://github.com/pedromews/ihc) and ensure at least 70%.

It's architecture is available **in at least one of the following** forms:

- [ ] This item has an architecture linked in it.
- [ ] This item delivery was explained in some form in the PR(e.g. text description, MURAL link).

# Test Coverage

<add the coverage screenshot and any further comments about the tests, if necessary>

Change the status from **draft** to **Ready to review** when this PR is ready to be reviewed.
