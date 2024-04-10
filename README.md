# Description

<describe here your changes, what you're fixing, etc>

**[Architecture Design Document](https://github.wdf.sap.corp/pages/GS-HCM-SLE/tioga-documentation/home/conventions/pull-requests/#merging)**:  [description](link)

# Definition of Done Checklist

Before, setting the PR to **Ready to review**, make sure to meet the Definition of Done criteria bellow:

The proper **tracking** of the change is done :
- [ ] Naming the PR's title with Jira item's suffix (e.g. _NGP-1234/Title_).
- [ ] If applicable, setting the POM version and updating [changelog](/README.md).  
  Use `mvn versions:set -DnewVersion:x.x.x` and `mvn versions:commit`, or run the [Version Updater](https://github.wdf.sap.corp/I535446/versionUpdater).
- [ ] Traceability linking has been added to relevant tests ([more information](https://github.wdf.sap.corp/pages/nextgenpayroll-zugspitze-infrastructure/public-howtos/quality/testing/traceability-report/)).

If you are delivering or updating an **entity**, make sure the following checks have been performed:

- [ ] Use `@Column(updatable = false)` for immutable fields and add `@RetentionPeriod` to root entities, [see more here](https://jira.successfactors.com/browse/NGP-14832).
- [ ] Update API Views according to entities' changes. This may impact UIs and other services, in this case raise the flag!
- [ ] Java docs added to outbound events and entities.
- [ ] Input Validation annotations have been added to API fields ([more information](https://github.wdf.sap.corp/pages/nextgenpayroll-zugspitze-infrastructure/public-howtos/cloud-native-platform/security/input-validations/#input-validation-security-side)).

:warning: If you are making a database change, make sure the following checks have been performed: :warning:

- [ ] Database files updated according to changes, remember to follow the [guide](https://github.wdf.sap.corp/pages/nextgenpayroll-zugspitze-infrastructure/public-howtos/cloud-native-platform/db-migration/hdbmigrationtable-examples/) for adding new columns. :page_facing_up:
- [ ] Merge the PR only after 14:00 BRT and if there is a succesfully built vector! :no_entry_sign:
- [ ] After the PR is released, execute our E2E tests (ALL_CAN) in Dev/XAllFeaturesEU10004 and monitor the DwC deployment, migration, and activation of the new vector. :white_check_mark:

If you are delivering a new use of **another service's API**, make sure the following checks have been performed:

- [ ] Contract test are in place and maintained ([more information](https://github.wdf.sap.corp/pages/nextgenpayroll-zugspitze-infrastructure/public-howtos/quality/testing/consumer-driven-contracts/contract-tests/)).

If you are delivering a new **command executor** or an **event handler**, make sure the following checks have been performed:

- [ ] Configure Executors and Handlers annotations properties (e.g. `routingContext`, `nextAtomicProcessTrigger`, `mandatory`) ([more information](https://github.wdf.sap.corp/pages/nextgenpayroll-zugspitze-infrastructure/public-howtos/microservice/process-tracking/#design-time-information-to-build-the-process-map)).

It was **built and tested** by:

- [ ] Testing locally with the latest version of the code.
- [ ] [Run mutation testing](https://sap-global-services.slack.com/archives/C019GA3CNQP/p1613738009011200) and ensure at least 70%.

It's architecture is available **in at least one of the following** forms:

- [ ] This item has an architecture linked in it.
- [ ] This item delivery was explained in some form in the PR(e.g. text description, MURAL link).

# Test Coverage

<add the coverage screenshot and any further comments about the tests, if necessary>

Change the status from **draft** to **Ready to review** when this PR is ready to be reviewed.
