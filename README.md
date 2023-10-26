# Thought Process

## Pipeline

- Do I have missing data? How does my missing data behave?
    - imputation or drop viable?
- Are all instances labelled? Are they trustful?
- Are these features consistent and informative? Compare over different periods of time for temporal consistency? Compare across groups consistency?
- What is the interpretability of sources?
- What is the granularity (period for temporal, units, etc)?
    - Should I normalize (look at distributions)?
- What is the precision of the values and the units?
- Do I have enough data to train my model?
- Are concepts equally represented in data?
- Is my data noisy? What is the source/origin of the noise? Is this noise truly random?


## Scaling

1. `RobustScaler` (if model susceptible to outliers)
2. `StandardScaler` (to translate to Z-scores)
3. `MinMaxScaler` (other use cases

## Transformations

1. `np.log1p`
2. `np.log`
3. `scipy.special.boxcox1p`

## Plotting
```[python]
g = sns.FacetGrid(train_df, col='Survived')
g.map(plt.hist, 'Age', bins=20)
```

## Date Commands
```[python]
start_date = pd.to_datetime("2012-01-01")
end_date = start_date + pd.Timedelta("149D")
mask = (timeseries["ds"] >= start_date) & (timeseries["ds"] < end_date)
timeseries = timeseries[mask]

# Resample to hourly
timeseries = timeseries.set_index("ds").resample("H").sum()
timeseries.head()
```
## Group Information

```[python]
## GROUPBY FEATURE
customer["AverageIncome"] = (
    customer.groupby("State")  # for each state
    ["Income"]                 # select the income
    .transform("mean")         # and compute its mean
)

## CLUSTERING
kmeans = KMeans(n_clusters=6)
X["Cluster"] = kmeans.fit_predict(X)
X["Cluster"] = X["Cluster"].astype("category")

X.head()

sns.relplot(
    x="Longitude", y="Latitude", hue="Cluster", data=X, height=6,
)
# check if informative by looking at cluster dist over labels
X["MedHouseVal"] = df["MedHouseVal"]
sns.catplot(x="MedHouseVal", y="Cluster", data=X, kind="boxen", height=6);
```

## Metrics
* RMSLE -- less sensitive to the scale of values, symmetric (to over/under), and appropriate for data with exponential growth or when percentage errors are meaningful
* MAPE -- sensitive to small values, interpretable, symmetric (to over/under)

## Model Tips

- Linear models learn sums and differences naturally, but can't learn anything more complex.
- Ratios seem to be difficult for most models to learn. Ratio combinations often lead to some easy performance gains.
- Linear models and neural nets generally do better with normalized features. Neural nets especially need features scaled to values not too far from 0. Tree-based models (like random forests and XGBoost) can sometimes benefit from normalization, but usually much less so.
- Tree models can learn to approximate almost any combination of features, but when a combination is especially important they can still benefit from having it explicitly created, especially when data is limited.
- Counts are especially helpful for tree models, since these models don't have a natural way of aggregating information across many features at once.
  
## Examples
* [Seasonal ARIMA w/ Cross Validation](https://www.kaggle.com/code/taufikadi/seasonal-arima-with-cross-validation)
* [EDA which makes sense](https://www.kaggle.com/code/ambrosm/pss3e23-eda-which-makes-sense)
* [Survival Analysis w/ Cox Prop Hazards](https://www.kaggle.com/code/bryanb/survival-analysis-with-cox-model-implementation)
* [NLP Features](https://www.kaggle.com/code/navneetkr123/nlp-feature-engineering-beginners)
* [Titanic Tutorial](https://www.kaggle.com/code/startupsci/titanic-data-science-solutions)




